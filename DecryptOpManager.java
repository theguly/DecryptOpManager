/*
 * javac DecryptOpManager
 * java -cp . DecryptOpManager [encrypt|decrypt] string
 *
 */
public class DecryptOpManager {

  private static String baseConvertor(String name1) {
    StringBuffer encoded = new StringBuffer();
    String[] base = new String[60];
    base[0] = "0"; base[1] = "1"; base[2] = "2"; base[3] = "3";
    base[4] = "4"; base[5] = "5"; base[6] = "6"; base[7] = "7";
    base[8] = "8"; base[9] = "9"; base[10] = "a"; base[11] = "b";
    base[12] = "c"; base[13] = "d"; base[14] = "e"; base[15] = "f";
    base[16] = "g"; base[17] = "h"; base[18] = "i"; base[19] = "j";
    base[20] = "k"; base[21] = "l"; base[22] = "m"; base[23] = "n";
    base[24] = "o"; base[25] = "p"; base[26] = "q"; base[27] = "r";
    base[28] = "s"; base[29] = "t"; base[30] = "u"; base[31] = "v";
    base[32] = "w"; base[33] = "x"; base[34] = "y"; base[35] = "z";
    base[36] = "A"; base[37] = "B"; base[38] = "C"; base[39] = "D";
    base[40] = "E"; base[41] = "F"; base[42] = "G"; base[43] = "H";
    base[43] = "I"; base[44] = "J"; base[45] = "K"; base[46] = "L";
    base[47] = "M"; base[48] = "N"; base[49] = "O"; base[50] = "P";
    base[51] = "Q"; base[52] = "R"; base[53] = "S"; base[54] = "T";
    base[55] = "U"; base[56] = "V"; base[57] = "W"; base[58] = "X";
    base[59] = "Y";

    long quotient = 0L;
    long reminder = 0L;
    int k1 = 0;
    String fame = new String(name1);
    for (int j1 = 0; j1 < name1.length(); j1++) {
      fame = name1.substring(j1);
      StringBuffer part = new StringBuffer();
      int p = 0;
      k1 = 0; reminder = 0L;
      for (; (part.length() != 5) && (k1 < fame.length()); k1++) {
        String test = fame.substring(p, k1 + 1);
        if (test.equals("0")) {
          part.append("0"); p++;
        } else {
          quotient = Long.parseLong(test) / 60L;
          reminder = Long.parseLong(test) % 60L;
          StringBuffer elabtemp = new StringBuffer();
          if (quotient != 0L) elabtemp.append(quotient).toString();
          String elab = elabtemp.toString();
          StringBuffer temp1 = new StringBuffer();
          for (int q = 0; q < elab.length(); q++) {
            if ((elab.length() != q + 1) && (!elab.substring(q, q + 1).equals("0")) && (Integer.parseInt(elab.substring(q, q + 2)) < 60)) {
              temp1.append(base[Integer.parseInt(elab.substring(q, q + 2))]);
              q++;
            } else {
              temp1.append(Integer.parseInt(elab.substring(q, q + 1)));
            }
          }
          if ((temp1.length() == 5 - part.length()) || (k1 == fame.length() - 1)) {
            part.append(temp1.toString());
          }
        }
      }
      part.append(base[(int)reminder]);
      encoded.append(part.toString());
      j1 = j1 + k1 - 1;
    }
    String toBeReturned = encoded.toString();
    int triplepos = 0;
    while ((triplepos = toBeReturned.indexOf("000")) != -1) {
      toBeReturned = new StringBuffer(toBeReturned).replace(triplepos, triplepos + 3, "Z").toString();
    }

    return toBeReturned;
  }

  public static String convertToBase(String encodedString) throws Exception {
	    
	    StringBuffer temp2 = new StringBuffer().append(encodedString);
	    int[] intbits = new int[temp2.length()];
	    StringBuffer fin = new StringBuffer();
	    
	    temp2 = new StringBuffer().append(encodedString).reverse();
	    

	    for (int k = 0; k < temp2.length(); k++) {
		      intbits[k]=((int)temp2.charAt(k)) - 28;
		      fin.append(intbits[k]);
		      
		}
	    
	    encodedString = baseConvertor(fin.toString());
    

	    return encodedString.toString();
	  }
  
  public static String convertFromBase(String encodedString) throws Exception {
    encodedString = baseDeconvertor(encodedString);

    StringBuffer temp2 = new StringBuffer().append(encodedString);
    String[] strbits = new String[temp2.length() / 2];
    int[] intbits = new int[temp2.length() / 2];
    StringBuffer fin = new StringBuffer();
    for (int k = 0; k < temp2.length() / 2; k++) {
      strbits[k] = temp2.toString().substring(2 * k, 2 * k + 2);
      intbits[k] = (Integer.parseInt(strbits[k]) + 28);
      fin.append((char)intbits[k]);
    }
    fin = new StringBuffer().append(fin).reverse();
    return fin.toString();
  }

  private static String baseDeconvertor(String input) throws Exception {
    String[] base = new String[60];
    base[0] = "0"; base[1] = "1"; base[2] = "2"; base[3] = "3";
    base[4] = "4"; base[5] = "5"; base[6] = "6"; base[7] = "7";
    base[8] = "8"; base[9] = "9"; base[10] = "a"; base[11] = "b";
    base[12] = "c"; base[13] = "d"; base[14] = "e"; base[15] = "f";
    base[16] = "g"; base[17] = "h"; base[18] = "i"; base[19] = "j";
    base[20] = "k"; base[21] = "l"; base[22] = "m"; base[23] = "n";
    base[24] = "o"; base[25] = "p"; base[26] = "q"; base[27] = "r";
    base[28] = "s"; base[29] = "t"; base[30] = "u"; base[31] = "v";
    base[32] = "w"; base[33] = "x"; base[34] = "y"; base[35] = "z";
    base[36] = "A"; base[37] = "B"; base[38] = "C"; base[39] = "D";
    base[40] = "E"; base[41] = "F"; base[42] = "G"; base[43] = "H";
    base[43] = "I"; base[44] = "J"; base[45] = "K"; base[46] = "L";
    base[47] = "M"; base[48] = "N"; base[49] = "O"; base[50] = "P";
    base[51] = "Q"; base[52] = "R"; base[53] = "S"; base[54] = "T";
    base[55] = "U"; base[56] = "V"; base[57] = "W"; base[58] = "X";
    base[59] = "Y";

    int Zpos = 0;
    while ((Zpos = input.indexOf("Z")) != -1) {
      String temp1 = input.substring(0, Zpos);
      String temp2 = input.substring(Zpos + 1);
      input = temp1 + "000" + temp2;
    }

    StringBuffer answer = new StringBuffer();
    int k = 0;
    long reminder = 0L;
    int co = input.length() / 6;
    while (k < co) {
      String part = input.substring(6 * k, 6 * k + 6);
      StringBuffer partnum = new StringBuffer();
      boolean startnum = false;
      for (int i = 0; i < 5; i++) {
        boolean isthere = false;
        for (int pos = 0; !isthere; pos++) {
          if (part.substring(i, i + 1).equals(base[pos])) {
            isthere = true;
            partnum.append(pos);
            if (pos == 0) {
              if (!startnum) answer.append("0"); 
            } else {
              startnum = true;
            }
          }
        }
      }
      boolean isthere = false;
      for (int pos = 0; !isthere; pos++) {
        if (part.substring(5).equals(base[pos])) {
          isthere = true;
          reminder = pos;
        }
      }
      if (partnum.toString().equals("00000")) {
        if (reminder != 0L) {
          String tempo = new Long(reminder).toString();
          String temp1 = answer.toString().substring(0, answer.length() - tempo.length());

          answer = new StringBuffer(temp1).append(tempo);
        }

      } else {
        answer.append(Long.parseLong(partnum.toString()) * 60L + reminder);
      }

      k++;
    }
    if (input.length() % 6 != 0) {
      String end = input.substring(6 * k);
      StringBuffer partnum = new StringBuffer();
      if (end.length() > 1) {
        int i = 0;
        boolean startnum = false;
        for (i = 0; i < end.length() - 1; i++) {
          boolean isthere = false;
          for (int pos = 0; !isthere; pos++) {
            if (end.substring(i, i + 1).equals(base[pos])) {
              isthere = true;
              partnum.append(pos);
              if (pos == 0) {
                if (!startnum) answer.append("0");
              } else {
                startnum = true;
              }
            }
          }
        }
        boolean isthere = false;
        for (int pos = 0; !isthere; pos++) {
          if (end.substring(i).equals(base[pos])) {
            isthere = true;
            reminder = pos;
          }
        }
        answer.append(Long.parseLong(partnum.toString()) * 60L + reminder);
      } else {
        boolean isthere = false;
        for (int pos = 0; !isthere; pos++) {
          if (end.equals(base[pos])) {
            isthere = true;
            reminder = pos;
          }
        }
        answer.append(reminder);
      }
    }
    return answer.toString();
  }

	public static void main(String[] args) {

		if(args.length < 2) {
			System.out.println("use: java -cp . DecryptOpManager [encrypt|decrypt] string");
			System.exit(0);
		}
		if (args[0].equals ("decrypt")) {
			try {
				System.out.println(DecryptOpManager.convertFromBase(new String (args[1])));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (args[0].equals ("encrypt")) {
			try {
				System.out.println(DecryptOpManager.convertToBase(new String (args[1])));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("unknown option: " + args[0]);
		}
	}
}
