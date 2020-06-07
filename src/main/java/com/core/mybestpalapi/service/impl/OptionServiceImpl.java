package com.core.mybestpalapi.service.impl;

import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.IOptionRepository;
import com.core.mybestpalapi.persistence.model.Option;
import com.core.mybestpalapi.service.IOptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class OptionServiceImpl extends AbstractService<Option> implements IOptionService {
  IOptionRepository optionsRepository;
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
  public final IOptionRepository getRepoExecutor() {
    return optionsRepository;
  }
}
