import { Component, OnInit } from "@angular/core";
import { ExchangeRateResponse } from "../types/ExchangeRateResponse";
import { ExchangeRateService } from "../services/exchange-rate.service";
import { CurrencyCode } from "../types/CurrencyCode";
import { ExchangeRateRequest } from "../types/ExchangeRateRequest";

@Component({
    standalone: true,
    selector: "app-root",
    templateUrl: "./app.component.html",
    providers: [ExchangeRateService],
})
export class AppComponent implements OnInit {
    constructor(private exchangeRateService: ExchangeRateService) {}

    async getExchangeRate() {
        const base: CurrencyCode = "USD";
        const target: CurrencyCode[] = ["EUR", "GBP"];
        const request: ExchangeRateRequest = {
            latest: base,
            currencies: target,
        };
        let response: ExchangeRateResponse = await this.exchangeRateService.getExchangeRate(request);

        const json = {
            [base]: {
                timestamp: Date.now(),
                rates: {
                    ...response.data,
                },
            },
        };
    }

    ngOnInit(): void {
        this.getExchangeRate();
    }
}
