package a.bitvector.a;

/**
 * A bit vector class
 * This class represents a bit vector which implements the interface IBitVector
 * and has functionality to do all bit vector operations
 */
public class BitVector implements IBitVector
{

	// bitVec - an integer array to store the BitVectors
	int[] bitVec;
	
	/**
	 * Constructor for BitVector which initializes the class variable bitVec 
	 */
	public BitVector() {
		bitVec = new int[]{0};
	}
	
	@Override
	/**
	 * Function to determine if the bit at position i is set.
	 * @param i representing the number whose bit value needs to be found
	 * @return True: if bit set, else False
	 */
	public boolean get(int i) {
		int index = i/32;
		
		if(index+1>bitVec.length)
			return false;
		
		int pos = i%32; 
		int getVal = 1;
		getVal = getVal<<pos;
		
		return (bitVec[index]&getVal)!=0;
	}

	@Override
	/**
	 * Function to set the bit at position i.
	 * @param i representing the number whose bit value needs to be set 
	 */
	public void set(int i) {
		//return if the bit is already set
		if(get(i))
		{
			return;
		}
		
		int index = i/32;
		int pos = i%32;
		
		int addvalue = 1;
		addvalue = addvalue<<pos;
		
		// Increasing the bitVec size dynamically
		if (index+1>bitVec.length)
		{
			int[] temp = new int[index+1];
			
			for(int j=0;j<index;j++)
			{
				if(j<bitVec.length)
				{
					temp[j]=bitVec[j];
				}
				else 
				{
					temp[j]=0;
				}
			}
			bitVec = temp;
		}
	
		bitVec[index]+=addvalue;
	}

	@Override
	/**
	 * Function to clear the bit at position i.
	 * @param i representing the number whose bit value needs to be cleared/set to zero
	 */
	public void clear(int i) {
		// if the bit is not set then no need to clear, return
		if(!get(i))
		{
			return;
		}
		
		int index = i/32;
		int pos = i%32;
		
		int subvalue = 1;
		subvalue=subvalue<<pos;
		
		bitVec[index]-=subvalue;
	}

	@Override
	/**
	 * Function to copy and set the bits in the argument BitVector b to the current BitVector
	 * @param b the BitVector b whose value needs to be copied.
	 */
	public void copy(BitVector b) {
		
		for (int i=0;i<b.bitVec.length; i++)
		{
			for (int j=0; j<32; j++)
			{
				int index=i*32+j;
				
				if(b.get(index))
				{
					this.set(index);
				}
			}
		}
	}

	@Override
	/**
	 * Function to determine the number of non-zero bits in the BitVector.
	 * @return the number of non-zero bits in the BitVector.
	 */
	public int size() {
		int nonZeroCount = 0;
		for(int i=0;i<bitVec.length;i++)
		{
			for(int j=0;j<32;j++)
			{
				int index=i*32+j;
				if(this.get(index))
				{
					nonZeroCount+=1;
				}
			}
			
		}
		return nonZeroCount;
	}

	@Override
	/**
	 * Iterator over the Integer values represented by this BitVector.
	 * To-do for part b
	 */
	public Iterator<Integer> iterator() {
		return null;
	}
    
}
