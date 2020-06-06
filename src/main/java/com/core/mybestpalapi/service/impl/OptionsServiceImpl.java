package com.core.mybestpalapi.service.impl;

import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.IOptionsRepository;
import com.core.mybestpalapi.persistence.model.Option;
import com.core.mybestpalapi.service.IOptionsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class OptionsServiceImpl extends AbstractService<Option> implements IOptionsService {
  IOptionsRepository optionsRepository;
  @Override
  public List<Option> getAll() {
    return null;
  }

  @Override
  public Option create(Option entity) {
    entity.setId(UUID.randomUUID().toString());
    entity.setCreatedDate(new Date());
    entity.setUpdatedDate(new Date());

    return getRepoExecutor().save(entity);
  }

  @Override
  public final IOptionsRepository getRepoExecutor() {
    return optionsRepository;
  }
}
