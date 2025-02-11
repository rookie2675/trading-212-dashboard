import { Injectable } from "@angular/core";
import { ExchangeRateRequest } from "../types/ExchangeRateRequest";
import { ExchangeRateResponse } from "../types/ExchangeRateResponse";

@Injectable()
export class ExchangeRateService {
    //TODO: Set the API Key in an environment variable
    private readonly API_KEY = "";
    private readonly BASE_URL = "https://api.freecurrencyapi.com/v1/";

    async getExchangeRate(request: ExchangeRateRequest): Promise<ExchangeRateResponse> {
        const url = new URL(`${this.BASE_URL}latest`);
        url.searchParams.set("latest", request.latest);
        url.searchParams.set("currencies", request.currencies.join(","));

        const headers = new Headers();
        headers.set("apiKey", this.API_KEY);

        const response: ExchangeRateResponse = await fetch(url, {
            headers: headers,
        }).then((response: Response) => response.json());

        console.log(response);
        return response;
    }
}
