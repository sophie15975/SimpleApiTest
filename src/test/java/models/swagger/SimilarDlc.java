package models.swagger;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimilarDlc{

	@JsonProperty("isFree")
	private boolean isFree;

	@JsonProperty("dlcNameFromAnotherGame")
	private String dlcNameFromAnotherGame;
}