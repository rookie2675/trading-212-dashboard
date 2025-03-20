import { CurrencyCode } from "./CurrencyCode";

export type ExchangeRateResponse = {
    data: {
        [currencyCode in CurrencyCode]: number;
    };
};
