package com.atm.api.service;

import java.io.IOException;
import java.math.BigDecimal;

public interface AtmService {
    BigDecimal inputBalanceReplenishment() throws IOException;
    BigDecimal inputWithdrawalCash() throws IOException;

}
