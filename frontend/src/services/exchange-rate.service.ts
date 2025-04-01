import { Injectable } from "@angular/core";
import { ExchangeRateRequest } from "../types/ExchangeRateRequest";
import { ExchangeRateResponse } from "../types/ExchangeRateResponse";
import { environment } from "../environments/environment";

@Injectable()
export class ExchangeRateService {
    async getExchangeRate(request: ExchangeRateRequest): Promise<ExchangeRateResponse> {
        const backendUrl = environment.backendUrl;
        const url = new URL(`${backendUrl}/currency-rate`);
        url.searchParams.set("baseCurrency", request.baseCurrency);
        url.searchParams.set("targetCurrencies", request.targetCurrencies.join(","));
        return await fetch(url, {}).then((response: Response) => response.json());
    }
}
