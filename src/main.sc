require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: patterns.sc
require: topics/service.sc
  
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
        go!: /Service/SuggestHelp
        
    state: NoMatch
        event!: noMatch
        a: Простите, я не понял. Переформулируйте, пожалуйста, запрос.

    state: Match
        event!: match
        a: {{$context.intent.answer}}