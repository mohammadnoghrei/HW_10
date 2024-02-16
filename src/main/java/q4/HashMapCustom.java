package q4;

import java.util.*;



    public class HashMapCustom<K, V> {
        private Entry<K, V>[] table;   //Array of Entry.
        private int capacity = 4;  //Initial capacity of HashMap

        static class Entry<K, V> {
            K key;
            V value;
            Entry<K, V> next;

            public Entry(K key, V value, Entry<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }


        @SuppressWarnings("unchecked")
        public HashMapCustom() {
            table = new Entry[capacity];
        }



        public void put(K newKey, V data) {
            if (newKey == null)
                return;    //does not allow to store null.

            //calculate hash of key.
            int hash = hash ( newKey );
            //create new entry.
            Entry<K, V> newEntry = new Entry<K, V> ( newKey, data, null );

            //if table location does not contain any entry, store entry there.
            if (table[hash] == null) {
                table[hash] = newEntry;
            } else {
                Entry<K, V> previous = null;
                Entry<K, V> current = table[hash];

                while (current != null) { //we have reached last entry of bucket.
                    if (current.key.equals ( newKey )) {
                        if (previous == null) {  //node has to be insert on first of bucket.
                            newEntry.next = current.next;
                            table[hash] = newEntry;
                            return;
                        } else {
                            newEntry.next = current.next;
                            previous.next = newEntry;
                            return;
                        }
                    }
                    previous = current;
                    current = current.next;
                }
                previous.next = newEntry;
            }
        }



        public boolean get(K key) {
            int hash = hash ( key );
            if (table[hash] == null) {
                return false;
            } else {
                Entry<K, V> temp = table[hash];
                while (temp != null) {
                    if (temp.key.equals ( key ))
                        return true;
                    temp = temp.next;
                }
                return false;
            }
        }



        public boolean remove(K deleteKey) {

            int hash = hash ( deleteKey );

            if (table[hash] == null) {
                return false;
            } else {
                Entry<K, V> previous = null;
                Entry<K, V> current = table[hash];

                while (current != null) { //we have reached last entry node of bucket.
                    if (current.key.equals ( deleteKey )) {
                        if (previous == null) {  //delete first entry node.
                            table[hash] = table[hash].next;
                            return true;
                        } else {
                            previous.next = current.next;
                            return true;
                        }
                    }
                    previous = current;
                    current = current.next;
                }
                return false;
            }

        }



        public void display() {

            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    Entry<K, V> entry = table[i];
                    while (entry != null) {
                        System.out.print ( "{" + entry.key + "=" + entry.value + "}" + " " );
                        entry = entry.next;
                    }
                }
            }

        }


        private int hash(K key) {
            return Math.abs ( key.hashCode () ) % capacity;
        }


//        public void replace(K key, V value) {
//            int index = hash (key);
//            List<Entry<K, V>> bucket = table[index];
//            for (Entry<K, V> entry : bucket) {
//                if (entry.key.equals(key)) {
//                    entry.value = value;
//                    return;
//                }
//            }
//        }
        public boolean isEmpty() {
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    Entry<K, V> entry = table[i];
                    while (entry != null) {
                        return true;
                    }
                }else {
                    return false;
                }
            }
            return false;
        }


    public static void main(String[] args) {
        HashMapCustom<String, String> hashMap = new HashMapCustom<> ();

        hashMap.put ( "miald", "javadi" );
        hashMap.put ( "mohammad", "noghreii" );


        hashMap.display ();
        System.out.println ();
        System.out.println ( hashMap.get ( "miald" ) );

//        hashMap.remove ( "miald" );
//        hashMap.remove ( "mohammad" );
        hashMap.display ();
        System.out.println ( hashMap.isEmpty () );

        hashMap.put ( "milad","es" );

        hashMap.display ();

    }
}