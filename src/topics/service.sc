theme: /Service
    
    state: SuggestHelp
        q: отмена || fromState = /Phone/Ask, onlyThisState = true
        a: Давайте я помогу вам купить билет?
        buttons:
            "Да"
            "Нет"
        
        state: Accepted
            q: * (да/давай*/хорошо) *
            a: Отлично!
            if: $client.phone
                go!: /Phone/Confirm
            else:
                go!: /Phone/Ask
            
        state: Rejected
            q: * (нет/не [надо/хочу]) * 
            a: Боюсь, что ничего другого я предложить не могу..
