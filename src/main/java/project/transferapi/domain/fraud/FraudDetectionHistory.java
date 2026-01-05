package project.transferapi.domain.fraud;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_FRAUD_DETECTION" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class FraudDetectionHistory {
}
