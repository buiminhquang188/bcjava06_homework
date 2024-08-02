package org.cybersoft.buoi36.mapper;

import java.util.List;

public interface IMapper<Entity, DTO> {
    List<DTO> entitiesToDTO(List<Entity> entities);

    DTO entityToDTO(Entity entity);
}
