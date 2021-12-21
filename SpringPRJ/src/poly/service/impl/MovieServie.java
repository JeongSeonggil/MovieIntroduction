package poly.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import poly.persistance.mapper.IMovieMapper;
import poly.service.IMovieService;

import javax.annotation.Resource;

@Service(value = "MovieService")
public class MovieServie implements IMovieService {

    private Logger log = Logger.getLogger(this.getClass());

    @Resource(name = "MovieMapper")
    private IMovieMapper movieMapper;
}
