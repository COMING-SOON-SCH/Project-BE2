package soon.coming.springbootdeveloper.common.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreatedDate
    protected LocalDateTime createdAt; //언제 만들어졌는가?

    @LastModifiedDate
    protected LocalDateTime updatedAt; //언제 수정했는가?

    protected LocalDateTime deletedAt; //언제 삭제됐는가?

    /** 삭제 로직이 있을 경우 해당 메서드를 호출하여 삭제 시간 표시 */
    protected void setdeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
