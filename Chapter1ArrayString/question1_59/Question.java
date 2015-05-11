/**
    1.59    Read N characters Given Read4
    The API: int read4(char *buf) reads 4 characters at a time from a file.
    The return value is the actual number of characters read. For example, it returns 3 if there
    is only 3 characters left in the file. 
    By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
    Note: The read function will only be called once for each test case.
    (CleanCodeHandbook--15)
     
    Read N Characters Given Read4 -- Call Multiple times 
    Similar to Question [15. Read N Characters Given Read4], but the read function may be called multiple times.
    (CleanCodeHandbook--16)
 */
package question1_59;

class Reader4 {
    public int read4(char[] buffer){
        
        return 4;
    }
}


class ReaderOneTime extends Reader4 {
    
    public int read(char[] buf, int n){
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while(!eof && readBytes<n) {
            int sz = read4(buffer);
            eof = sz<4;
            int bytes = Math.min(n-readBytes, sz);
            System.arraycopy(buffer /*src*/, 0, buf /* dest */, readBytes /*destPos*/, bytes /*length*/);
            readBytes += bytes;
        }
        return readBytes;
    }
}

class ReaderMultipleTimes extends Reader4 {
    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;
    
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while(!eof && readBytes<n){
            if(bufsize==0){
                bufsize = read4(buffer);
                eof = bufsize<4;
            }
            int bytes = Math.min(n-readBytes, bufsize);
            System.arraycopy(buffer /*src*/, offset /*srcPos*/, buf /*dest*/, readBytes /*destPos*/, bytes /*length*/);
            offset = (offset+bytes)%4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
    
}


public class Question {

}
