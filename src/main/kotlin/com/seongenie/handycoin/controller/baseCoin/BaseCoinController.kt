package com.seongenie.handycoin.controller.baseCoin

import com.seongenie.handycoin.service.BaseCoinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import retrofit2.http.Path

@RestController
@RequestMapping("/api/v1/base")
class BaseCoinController {

    @Autowired
    lateinit var baseCoinService : BaseCoinService

//    @RequestMapping(value = "/create/{exchange}/{coin}", method = [RequestMethod.POST])
//    fun createFavorCoins(@PathVariable("exchange") exchange : String, @PathVariable("coin") coin : String)  {
//        var coinView = BaseCoinView(exchange, coin)
//        baseCoinService.createBaseCoin(coinView)
////        return basicCoinService.createBasicCoin(coinView)
//    }

    @RequestMapping(value = "/getBaseCoins", method = [RequestMethod.GET])
    fun getBaseCoinList() : ExchangeCoinResponse {
        return baseCoinService.getBaseCoinList()
    }

    @RequestMapping(value = "/getCoins/{exchange}", method = [RequestMethod.GET])
    fun getCoins(@PathVariable("exchange") exchange : String) : List<String> {
        return baseCoinService.getBaseCoins(exchange).map{it -> it.coin}
    }

    @RequestMapping(value = "/getExchanges/{coin}", method = [RequestMethod.GET])
    fun getExchanges(@PathVariable("coin") coin : String) : List<String> {
        return baseCoinService.getBaseExchanges(coin).map{it -> it.exchange}
    }

}