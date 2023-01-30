theme: /City
    
    state: TicketPurchase
        intent!: /TicketPurchase
        script:
            $reactions.answer(toPrettyString($parseTree));
    
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
                
    state: localCatchAll
        q: * || fromState = /City/Departure
        a: Простите, я вас не поняла.
        go!: {{ $session.lastState }}
