require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: city/cities-ru.csv
    module = sys.zb-common
    name = Cities
    var = Cities
require: functions.js
require: patterns.sc
require: topics/service.sc
require: topics/phone.sc
require: topics/discount.sc
require: topics/city.sc
require: topics/weather.sc

require: dicts/discount.yaml
    var = discountInfo

init:

    $global.$converters = {};
    
    $global.$converters.CityConverter = function CityConverter(parseTree) {
        var id = parseTree.Cities[0].value;
        return Cities[id].value;
        };

    bind("postProcess", function($context) {
        $context.session.lastState = $context.currentState;
        log("@@@@" + toPrettyString($context.session));
        });


theme: /

    state: Welcome
        q!: *start
        q!: $hi *
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                type: "image",
                imageUrl: "https://proprikol.ru/wp-content/uploads/2020/12/samolety-krasivye-kartinki-41.jpg",
                text: "Самолёт"
                });
        random:
            a: Добрый день!
            a: Здравствуйте!
            a: Приветствую!
        a: Меня зовут {{ capitalize($injector.botName) }}.
        # go!: /Service/SuggestHelp
    
    state: test
        q!: test
        a: test
        inlineButtons:
            {text:"Подписаться wjgfxcgjbvcvbnjmbvjkjhnbnm", callback_data: "Подписаться"}
    
    state:: test2
        q!: test2
        a: test2
        buttons:
            "Да tyfdfdgdasgfkjgsakjfgsdkhjfgksdgf"
            "Нет sdghfjkhdgfjksgfkjgsdkjhg"
        
    state: NoMatch || noContext = true
        event!: noMatch
        a: Простите, я не понял. Переформулируйте, пожалуйста, запрос.
        go!: {{ $context.session.lastState }}

    state: Match
        event!: match
        a: {{$context.intent.answer}}