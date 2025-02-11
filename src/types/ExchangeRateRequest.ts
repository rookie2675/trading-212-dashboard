import { CurrencyCode } from "./CurrencyCode";

export type ExchangeRateRequest = {
    latest: CurrencyCode;
    currencies: CurrencyCode[];
};
