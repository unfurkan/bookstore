package com.getir.bookstore.common.mapper;

import java.util.List;


public interface BaseResponseMapper<Response, Entity> {

    Response toResponse(Entity entity);

    List<Response> toListResponse(List<Entity> entities);

}
