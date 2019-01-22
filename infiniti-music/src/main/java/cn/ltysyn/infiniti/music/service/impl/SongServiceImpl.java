package cn.ltysyn.infiniti.music.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.infiniti.music.entity.Song;
import cn.ltysyn.infiniti.music.service.ISongService;

@Service(value = "songService")
public class SongServiceImpl extends BaseService implements ISongService {

	@Override
	public List<Song> getAll() {
		// TODO Auto-generated method stub
		return songDao.findAll();
	}

	@Override
	public Song getById(Long id) {
		// TODO Auto-generated method stub
		return songDao.findBySongId(id);
	}

}
