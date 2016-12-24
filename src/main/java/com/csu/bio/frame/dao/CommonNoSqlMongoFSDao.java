package com.csu.bio.frame.dao;

import java.io.InputStream;

import com.mongodb.gridfs.GridFSDBFile;

/**
 * 
 */
public interface CommonNoSqlMongoFSDao {

	public void saveFile(InputStream in, Object id, String fileName, String contentType, Boolean persist);

	public void saveFile(byte[] in, Object id, String fileName, String contentType, Boolean persist);

	public GridFSDBFile getFileById(Object id);

	public GridFSDBFile getFileByFileName(String fileName);

	public void updateFilePersist(Object id, Boolean persist);

}
