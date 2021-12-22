package poly.persistance.mapper;

import config.Mapper;
import poly.dto.NlpDTO;

import java.util.List;

@Mapper("NlpMapper")
public interface INlpMapper {
    List<NlpDTO> getWord(NlpDTO nlpDTO) throws Exception;
}
