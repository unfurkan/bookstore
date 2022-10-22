package com.getir.bookstore.common.usecase;

public interface BaseUseCase<INPUT, OUTPUT> {

    OUTPUT exec(INPUT input);

}
