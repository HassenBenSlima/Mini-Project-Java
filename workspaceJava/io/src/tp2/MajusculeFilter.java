package tp2;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class MajusculeFilter  extends FilterReader{

	Reader in;
	
	public MajusculeFilter(Reader in) {
		super(in);
		this.in = in;
	}
	
	@Override
	public int read() throws IOException {
		
		int a;
		while((a = in.read()) != -1)
		{
			System.out.println(Character.toUpperCase((char) a));
		}
		
		return 0;

		
	}
	

}
