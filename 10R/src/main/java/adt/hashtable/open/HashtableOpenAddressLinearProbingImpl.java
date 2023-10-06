package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
        if (isFull()) throw new HashtableOverflowException();
        if (element != null) {
            boolean found = false;
            int probe = 0;
            int hash = getHash(element, probe);

            while (table[hash] != null && !table[hash].equals(deletedElement)) {
                COLLISIONS++;
                if (table[hash].equals(element)) {
                    found = true; 
                    break;
                }

                probe++;
                hash = getHash(element, probe);
            }

            if (!found) {
                table[hash] = element;
                elements++;
            }
        }
	}

	@Override
	public void remove(T element) {
        if (!isEmpty() && element != null) {
            int probe = 0;
            int hash = getHash(element, probe);

            while (table[hash] != null) {
                if (table[hash].equals(element)) {
                    table[hash] = new DELETED();
                    elements--;
                    if (probe > 0) COLLISIONS--;
                    break;
                }
                probe++;
                hash = getHash(element, probe);
            }
        }
	}

	@Override
	public T search(T element) {
        if (element == null || isEmpty()) return null;
        
        int probe = 0;
        int hash = getHash(element, probe);

        while (table[hash] != null) {
            if (((T) table[hash]).equals(element)) return element;
            probe++;
            hash = getHash(element, probe);
        }

        return null;
	}

	@Override
	public int indexOf(T element) {
        if (element == null || isEmpty()) return -1;

        int probe = 0;
        int hash = getHash(element, probe);

        while (table[hash] != null) {
            if (table[hash].equals(element)) return hash;
            probe++;
            hash = getHash(element, probe);
        }

        return -1;
	}

    private int getHash(T element, int probe) {
        return ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe);
    }

}
