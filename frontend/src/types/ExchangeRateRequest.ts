import { CurrencyCode } from "./CurrencyCode";

export type ExchangeRateRequest = {
    baseCurrency: CurrencyCode;
    targetCurrencies: CurrencyCode[];
};
