theme: /City
    
    state: TicketPurchase
        intent!: /TicketPurchase
        script:
            $session.departureCity = capitalize($nlp.inflect($parseTree._departure, "gent"));
            $session.arrivalCity = capitalize($nlp.inflect($parseTree._destination, "accs"));
            $session.date = $parseTree._date.day + '/' + $parseTree._date.month + '/' + $parseTree._date.year;
            # $reactions.answer(toPrettyString($parseTree));
        a: {{ $session.date }} отправляемся из {{ $session.departureCity }} в {{ $session.arrivalCity }}.
    
    state: Departure
        a: Назовите, пожалуйста, город отправления.
        
        state: Get
            q: * $city *
            script:
                # var id = $parseTree.city[0].value;
                # $session.departureCity = Cities[id].value.name;
                $session.departureCity = $parseTree._city;
                # $reactions.answer('@@@@@@@@ parseTree.city: \n' + toPrettyString($parseTree.city) + '\n');
            a: Итак, город отправления: {{ $session.departureCity.name }}.
            go!: /City/Arrival
        
    state: Arrival
        a: Назовите, пожалуйста, город прибытия.
        
        state: Get
            q: * $city *
            script:
                $session.arrivalCity = $parseTree._city;
            a: Итак, город прибытия: {{ $session.arrivalCity.name }}.
            go!: /Weather/CurrentWeather
                
    state: localCatchAll
        q: * || fromState = /City/Departure
        a: Простите, я вас не поняла.
        go!: {{ $session.lastState }}
