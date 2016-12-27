package com.csu.bio.util.oper;

import java.io.IOException;
import java.io.InputStream;

import com.mongodb.gridfs.GridFSDBFile;

/**
 *
 * @author kayzhao
 * @version 2016年12月28日
 */
public class GridfsUtil {

	/**
	 * gridfs file to bytearray
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(GridFSDBFile file) throws IOException {
		InputStream is = file.getInputStream();
		int len = (int) file.getLength();
		int pos = 0;
		byte[] b = new byte[len];
		while (len > 0) {
			int read = is.read(b, pos, len);
			pos += read;
			len -= read;
		}
		return b;
	}
}
