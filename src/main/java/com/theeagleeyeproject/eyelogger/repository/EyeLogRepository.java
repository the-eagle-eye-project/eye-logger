package com.theeagleeyeproject.eyelogger.repository;


import com.theeagleeyeproject.eyelogger.entity.EyeLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@link EyeLogEntity} used to query the Log index.
 *
 * @author John Robert Martinez Ponce
 */
@Repository
public interface EyeLogRepository extends ElasticsearchRepository<EyeLogEntity, String> {

    /**
     * Used to find all the logs based on a transaction id.
     *
     * @param integrationId transaction id
     * @param pageable      used to page when there is a lot of logs for a specific transaction
     * @return a {@link Page} of type {@link EyeLogEntity}
     */
    Page<EyeLogEntity> findByIntegrationId(String integrationId, Pageable pageable);

    /**
     * Used to find logs based on an E2E transaction id, to connect different logs together on a search.
     *
     * @param e2eTransactionId id stored in the log index
     * @return a {@link List} of type {@link EyeLogEntity}
     */
    List<EyeLogEntity> findByE2eTransactionId(String e2eTransactionId);

}
