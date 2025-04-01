import { Component } from "@angular/core";
import { ExchangeRateResponse } from "../types/ExchangeRateResponse";
import { ExchangeRateService } from "../services/exchange-rate.service";
import { ExchangeRateRequest } from "../types/ExchangeRateRequest";

@Component({
    standalone: true,
    selector: "app-root",
    templateUrl: "./app.component.html",
    providers: [ExchangeRateService],
})
export class AppComponent {
    constructor(private readonly exchangeRateService: ExchangeRateService) {}

    async getExchangeRate() {
        const request: ExchangeRateRequest = {
            baseCurrency: "USD",
            targetCurrencies: ["EUR", "GBP"],
        };

        const response: ExchangeRateResponse = await this.exchangeRateService.getExchangeRate(request);
        console.log(response);
    }
}
