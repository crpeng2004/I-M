package cn.ltysyn.inmusic.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ltysyn.inmusic.music.entity.Album;
import cn.ltysyn.inmusic.music.entity.Song;
import cn.ltysyn.inmusic.music.service.IAlbumService;

@Service(value = "albumService")
public class AlbumServiceImpl extends BaseService implements IAlbumService {

	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		return albumDao.findAll();
	}

	@Override
	public Album getByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		return albumDao.findByAlbumId(albumId);
	}

	@Override
	public List<Album> getByArtistId(Integer artistId) {
		// TODO Auto-generated method stub
		return albumDao.findByAritstId(artistId);
	}

	@Override
	public List<Album> getByPage(int page, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page-1, limit);
		Page<Album> pageResult = albumDao.findAll(pageable);
		return pageResult.getContent() == null ? new ArrayList<>() : pageResult.getContent();
	}

	@Override
	public List<Album> getByPageOrderByPublishTime(int page, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page-1, limit);
		Page<Album> pageResult = albumDao.findByOrderByPublishTimeDesc(pageable);
		return pageResult.getContent() == null ? new ArrayList<>() : pageResult.getContent();
	}

	@Override
	public List<Album> searchAlbum(String keyword) {
		// TODO Auto-generated method stub
		return albumDao.findByAlbumNameLike(keyword);
	}

	@Override
	public Page<Album> getAllByPage(int page, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page-1, limit);
		return albumDao.findAll(pageable);
	}

	@Override
	public boolean addAlbum(Album album) {
		// TODO Auto-generated method stub
		try {
			albumDao.save(album);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delAlbum(long albumId) {
		// TODO Auto-generated method stub
		try {
			// 删除专辑
			albumDao.deleteById(albumId);
			// 同时删除该专辑下所有的音乐
			List<Song> songs = songDao.findByAlbumId(albumId);
			songs.stream().forEach(song -> {
				songDao.deleteById(song.getSongId());
			});
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
