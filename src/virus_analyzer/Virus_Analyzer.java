/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package virus_analyzer;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Hex;

//import org.apache.commons.codec.binary.Hex;
/**
 *
 * @author Ransiluni
 */
public class Virus_Analyzer {

    /**
     * @param args the command line arguments
     */
    	public static void main(String[] args) {
                try {
                    FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                    dialog.setMode(FileDialog.LOAD);
                    dialog.setVisible(true);
                    
                    
                    String file = dialog.getDirectory()+dialog.getFile();
                    System.out.println(file);
                    MessageDigest md = MessageDigest.getInstance("MD5");
                   // File fl=new File(path);
                    String digest = getDigest(new FileInputStream(file), md, 2048);
                   
                    System.out.println("MD5 Digest:" + digest);
                    JOptionPane.showMessageDialog(null,"File name : "+file+"\nMD5 hash Code : " +digest);
                    ResultSet rsd = dbms.getData("select * from virus_md5 where vxMD5='"+digest+"'" );
                    
                    if (rsd.first()) {
                        String name = rsd.getString("vxVirusName");
                        String type = rsd.getString("vxType");
                        JOptionPane.showMessageDialog(null, "File is infected with "+name+"!\ntype : "+type);
                        //for testing purposes manifest.mf in the source folder is added to the database as a virus file
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "File is clean");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }

	}

	public static String getDigest(InputStream is, MessageDigest md, int byteArraySize)
			throws NoSuchAlgorithmException, IOException {

		md.reset();
		byte[] bytes = new byte[byteArraySize];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			md.update(bytes, 0, numBytes);
		}
		byte[] digest = md.digest();
		String result = new String(Hex.encodeHex(digest));
		return result;
	}
        
                   
    
}
