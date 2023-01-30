patterns:
    $hi = (привет*/здравствуй*)
    $phone = $regexp<79\d{9}>
    $city = $entity<Cities> || converter = $converters.CityConverter 
