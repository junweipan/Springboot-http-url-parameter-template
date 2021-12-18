package com.junwei.controller;

import com.junwei.entity.ResultData;
import com.junwei.entity.Weather;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {

    List<Weather> weatherList =  new ArrayList<>();

    // return all weather list data
    @RequestMapping(value = "/weathers", method = RequestMethod.GET)
    public ResultData<List<Weather>> getWeathers(){
        if(weatherList.isEmpty()){
            return ResultData.fail(999, "Data is null");
        }else {
            return ResultData.success(weatherList);
        }
    }

    // add a weather obj to weather list
    @RequestMapping(value = "/addWeather", method = RequestMethod.POST)
    public ResultData<Weather> addWeather(Weather weather){
        //copy weather to w
        Weather w = new Weather();
        w.setId(weather.getId());
        w.setLog(weather.getLog());
        w.setLat(weather.getLat());
        w.setCity(weather.getCity());
        w.setTemperature(weather.getTemperature());

        return ResultData.success(w);
    }


    // url format：http://localhost/getWeatherByCity?city=Messcow,London
    // parameter name in url is same to function parameter name in Controller
    /**
     * @param city
     * @return
     */
    @RequestMapping(value="/getWeatherByCity",method = RequestMethod.GET)
    public ResultData<List<Weather>> getWeatherByCity(String city) {

        List<Weather> newList = new ArrayList<>();
        for (Weather w : weatherList) {
            // city value "Messcow,London" contains any city name in weather, return the weather obj
            if(city.contains(w.getCity())){
                newList.add(w);
            }
        }
        return ResultData.success(newList);
    }


    // url format：http://localhost/getWeatherByCity?city=Messcow&lat=1211542
    /**
     * @param city
     * @param lat
     * @return
     */
    @RequestMapping(value="/getWeatherByCityLat",method = RequestMethod.GET)
    public ResultData<List<Weather>> getWeatherByCityLat(String city, String lat) {

        List<Weather> newList = new ArrayList<>();
        for (Weather w : weatherList) {
             if(w.getCity().equals(city) || w.getLat().equals(lat)){
                 newList.add(w);
            }
        }
        return ResultData.success(newList);
    }

    // http://localhost/weather/city/001/002
    /**
     * 4、@PathVariable get value in url
     * @param city1
     * @param city2
     * @return
     */
    @RequestMapping(value="/addUser4/{city1}/{city2}",method= RequestMethod.GET)
    public ResultData<List<Weather>> getWeatherby2Cities(@PathVariable String city1, @PathVariable String city2) {
        List<Weather> newList = new ArrayList<>();
        for (Weather w : weatherList) {
            if(city1.equals(w.getCity()) || city2.equals(w.getCity())){
                newList.add(w);
            }
        }
        return ResultData.success(newList);
    }

}
