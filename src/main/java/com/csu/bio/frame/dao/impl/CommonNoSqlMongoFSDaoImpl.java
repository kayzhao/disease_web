
package com.csu.bio.frame.dao.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.csu.bio.frame.dao.CommonNoSqlMongoFSDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Repository("CommonNoSqlMongoFSDao")
public class CommonNoSqlMongoFSDaoImpl implements CommonNoSqlMongoFSDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 保存文件，透明处理已存在的情况
	 * 
	 * @param in
	 *            文件输入流
	 * @param id
	 *            标识 可以是string，long，int，org.bson.types.ObjectId 类型
	 * @param fileName
	 *            文件名称
	 * @param persist
	 *            持久化态
	 */
	public void saveFile(InputStream in, Object id, String fileName, String contentType, Boolean persist) {
		GridFS gridFS = new GridFS(this.mongoTemplate.getDb());
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);

		if (gridFSDBFile == null) {
			GridFSInputFile gridFSInputFile = gridFS.createFile(in);
			gridFSInputFile.setId(id);
			gridFSInputFile.setFilename(fileName);
			gridFSInputFile.setContentType(contentType);
			gridFSInputFile.setMetaData(new BasicDBObject("persist", persist));

			gridFSInputFile.save();
		} else {
			String initFileName = gridFSDBFile.getFilename();
			gridFS.remove(query);
			GridFSInputFile gridFSInputFile = gridFS.createFile(in);
			gridFSInputFile.setId(id);
			gridFSInputFile.setFilename(initFileName);
			gridFSInputFile.setContentType(contentType);
			gridFSInputFile.setMetaData(new BasicDBObject("persist", persist));

			gridFSInputFile.save();
		}

	}

	@Override
	public void saveFile(byte[] in, Object id, String fileName, String contentType, Boolean persist) {
		GridFS gridFS = new GridFS(this.mongoTemplate.getDb());
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		if (gridFSDBFile == null) {
			GridFSInputFile gridFSInputFile = gridFS.createFile(in);
			gridFSInputFile.setId(id);
			gridFSInputFile.setFilename(fileName);
			gridFSInputFile.setContentType(contentType);
			gridFSInputFile.setMetaData(new BasicDBObject("persist", persist));
			gridFSInputFile.save();
		}
	}

	/**
	 * 获取文件
	 * 
	 * @param id
	 *            文件标识
	 * @return
	 */
	public GridFSDBFile getFileById(Object id) {
		GridFS gridFS = new GridFS(this.mongoTemplate.getDb());
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		return gridFSDBFile;
	}

	/**
	 * 获取第一个文件
	 * 
	 * @param fileName
	 *            文件名称
	 * @return
	 */
	public GridFSDBFile getFileByFileName(String fileName) {
		GridFS gridFS = new GridFS(this.mongoTemplate.getDb());
		DBObject query = new BasicDBObject("filename", fileName);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		return gridFSDBFile;
	}

	/**
	 * 更新文件的持久化状态
	 * 
	 * @param id
	 *            标识
	 * @param persist
	 *            持久化状态
	 */
	public void updateFilePersist(Object id, Boolean persist) {
		GridFS gridFS = new GridFS(this.mongoTemplate.getDb());
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);

		if (gridFSDBFile != null) {
			DBObject metaData = gridFSDBFile.getMetaData();

			if (metaData != null) {
				metaData = new BasicDBObject();
			}

			metaData.put("persist", persist);
			gridFSDBFile.save();
		}
	}

}
