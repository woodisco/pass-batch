package com.fastcampus.pass.repository.pass;

import com.fastcampus.pass.PassBatchApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PassBatchApplication.class)
@SpringJUnitConfig
class PassRepositoryTest {
    private final PassRepository passRepository;

    @Autowired
    PassRepositoryTest(PassRepository passRepository) {
        this.passRepository = passRepository;
    }

    @Test
    public void test_toPassEntity() {
        // given
        final LocalDateTime now = LocalDateTime.now();
        final String useId = "A1000000";

        BulkPassEntity bulkPassEntity = new BulkPassEntity();
        bulkPassEntity.setPackageSeq(1);
        bulkPassEntity.setUserGroupId("GROUP");
        bulkPassEntity.setStatus(BulkPassStatus.COMPLETED);
        bulkPassEntity.setCount(10);
        bulkPassEntity.setStartedAt(now.minusDays(60));
        bulkPassEntity.setEndedAt(now);

        // when
        final PassEntity passEntity = PassModelMapper.INSTANCE.toPassEntity(bulkPassEntity, useId);
        passRepository.save(passEntity);

        // then
        assertEquals(1, passEntity.getPassSeq());
        assertEquals(PassStatus.READY, passEntity.getStatus());
        assertEquals(10, passEntity.getRemainingCount());
        assertEquals(now.minusDays(60), passEntity.getStartedAt());
        assertEquals(now, passEntity.getEndedAt());
    }
}