package com.java7book.chapter7.ref;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileEditor3 {

	private static class FileData {
		private String filePath;
		private SoftReference<byte[]> dataRef;

		public FileData(String filePath, byte[] data) {
			this.filePath = filePath;
			this.dataRef = new SoftReference<byte[]>(data);
		}

		public String getFilePath() {
			return filePath;
		}

		public byte[] getData() {
			return dataRef.get() != null ? dataRef.get() : new byte[0];
		}
	}

	private FileData currentFile;
	//private List<SoftReference<FileData>> backgroundFiles = new ArrayList<>();
	private int MAX_OPEN_FILE = 20;
	private SoftReference<SoftReference<FileData>[]> ref;
	private SoftReference<List<SoftReference<FileData>>> backgroundFilesRef;
	
	private SoftReference<FileData> backgroundFile;
	
	public void openFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		filePath = path.toAbsolutePath().toString();
		System.gc();
		if (Files.exists(path)) {
			currentFile = new FileData(filePath, Files.readAllBytes(path));
		}
	}

	public void switchTo(String filePath) throws IOException {
		filePath = Paths.get(filePath).toAbsolutePath().toString();
		/*SoftReference<FileData> ref = null;
		List<SoftReference<FileData>> backgroundFiles = getBackgroundFilesRef();
		for (SoftReference<FileData> fileRef : backgroundFiles) {
			FileData fileData = fileRef.get();
			if (fileData != null && filePath.equals(fileData.getFilePath())) {
				ref = fileRef;
				break;
			}
		}
		moveCurrentFileToBackground();
		if (ref != null) {
			if (ref.get() != null) {
				currentFile = ref.get();
				ref.clear();
			}
			else {
				openFile(filePath);
			}
			backgroundFiles.remove(ref);
		} else {
			openFile(filePath);
		}*/
		
		if (backgroundFile != null && backgroundFile.get() != null){
			FileData fileData = backgroundFile.get();
			if (filePath.equals(fileData.getFilePath())) {
				currentFile = backgroundFile.get();
				backgroundFile.clear();
				backgroundFile = null;
			}
			else {
				moveCurrentFileToBackground();
				openFile(filePath);
			}
		}
		else {
			moveCurrentFileToBackground();
			openFile(filePath);
		}
	}
	
	@SuppressWarnings("unchecked")
	private SoftReference<FileData>[] getRef() {
		if (ref == null || ref.get() == null) {
			ref = new SoftReference<SoftReference<FileData>[]>((SoftReference<FileData>[]) Array.newInstance(SoftReference.class, MAX_OPEN_FILE));
		}
		return ref.get();
	}
	
	private List<SoftReference<FileData>> getBackgroundFilesRef() {
		if (backgroundFilesRef == null || backgroundFilesRef.get() == null) {
			backgroundFilesRef = new SoftReference<List<SoftReference<FileData>>>(new ArrayList<SoftReference<FileData>>());
		}
		return backgroundFilesRef.get();
	}

	private void moveCurrentFileToBackground() {
		/*if (currentFile != null) {
			List<SoftReference<FileData>> backgroundFiles = getBackgroundFilesRef();
			backgroundFiles.add(new SoftReference<FileData>(currentFile));
			currentFile = null;
		}*/
		if (currentFile != null){
			backgroundFile = new SoftReference<FileData>(currentFile);
			currentFile = null;
		}
	}

	public void useFile() throws IOException {
		if (currentFile != null) {
			System.out.println(String.format("文件%1$s的大小为 %2$d字节。",
					currentFile.getFilePath(), currentFile.getData().length));
		}
	}
}
