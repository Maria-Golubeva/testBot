theme: /Service
    
    state: SuggestHelp
        a: Давайте я помогу вам купить билет?
        buttons:
            "Да"
            "Нет"
        
        state: Accepted
            q: * (да/давай*/хорошо) *
            a: Отлично!
            
        state: Rejected
            q: * (нет/не [надо/хочу]) * 
            a: Боюсь, что ничего другого я предложить не могу..
