theme: /Weather
    
    state: CurrentWeather
        script:
            $temp.currentWeather = getCurrentWeather($session.arrivalCity.lat, $session.arrivalCity.lon);
        if: $temp.currentWeather
            a: В городе {{ $session.arrivalCity.name }} сейчас {{ $temp.currentWeather.description }}, {{ $temp.currentWeather.temp }}°C.
            # a: {{ toPrettyString($temp.currentWeather) }}
