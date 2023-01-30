theme: /City
    
    state: Departure
        a: Назовите, пожалуйста, город отправления.
        
        state: Get
            q: * $city *
            script:
                # var id = $parseTree.city[0].value;
                # $session.departureCity = Cities[id].value.name;
                $session.departureCity = $parseTree.city[0].value;
                # $reactions.answer('@@@@@@@@ parseTree.city: \n' + toPrettyString($parseTree.city) + '\n');
            a: Итак, город отправления: {{ toPrettyString($session.departureCity) }}.
        
        state: localCatchAll
            q: * || fromState = /City/Departure
            a: Простите, я вас не поняла.
            go!: {{ $session.lastState }}
