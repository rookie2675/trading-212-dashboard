import { Injectable } from "@angular/core";
import { ExchangeRateRequest } from "../types/ExchangeRateRequest";
import { ExchangeRateResponse } from "../types/ExchangeRateResponse";
import { environment } from "../environments/environment.development";

@Injectable()
export class ExchangeRateService {
    private readonly API_KEY = environment.apiKey;
    private readonly BASE_URL = "https://api.freecurrencyapi.com/v1/";

    async getExchangeRate(request: ExchangeRateRequest): Promise<ExchangeRateResponse> {
        const url = new URL(`${this.BASE_URL}latest`);
        url.searchParams.set("latest", request.latest);
        url.searchParams.set("currencies", request.currencies.join(","));

        const headers = new Headers();
        console.log(this.API_KEY);
        headers.set("apiKey", this.API_KEY);

        const response: ExchangeRateResponse = await fetch(url, {
            headers: headers,
        }).then((response: Response) => response.json());

        console.log(response);
        return response;
    }
}
