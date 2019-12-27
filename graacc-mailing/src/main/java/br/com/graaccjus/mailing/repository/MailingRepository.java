package br.com.graaccjus.mailing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.graaccjus.mailing.entity.MailingEntity;

@Repository
public interface MailingRepository extends CrudRepository<MailingEntity, Integer> {

}
