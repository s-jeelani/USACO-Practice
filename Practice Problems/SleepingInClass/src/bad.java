public class bad {


}

/*



            while(checkSame(index, 1) || checkSame(index, -1)){
                if(log.size() == 2){
                    counter++;
                    break;

                }
                boolean Break = false;
                while(checkSame(index, 1)){
                    if(log.size() == 2){
                        counter++;
                        break;

                    }

                    for (int i=0; i<index; i++){
                        if(log.get(i) < log.get(index)){
                            int y = log.get(i+1);
                            log.remove(i+1);
                            log.set(i, log.get(i)+y);
                            index--;
                            if(log.get(i) > log.get(index)){
                                index = i;
                            }
                            counter++;

                        }

                    }

                }

                while(checkSame(index, -1) && !Break){
                    if(log.size() == 2){
                        counter++;
                        break;

                    }
                    int i=log.size()-1;
                    while(i>index && i < log.size()){
                        if(log.size() == 2){
                            counter++;
                            Break = true;
                            break;

                        }
                        if(log.get(i) < log.get(index)){
                            int y = log.get(i-1);
                            log.set(i, log.get(i)+y);
                            log.remove(i-1);
                            if(log.get(i-1) > log.get(index)){
                                index = i-1;
                            }
                            counter++;
                        }
                        i--;
                    }

                }
            }
 */

/*
Sol 2
int counter = 0;
            int prevLogSize=-1;
            while(checkSame()){

                if(log.size() == 2){
                    counter++;
                    break;
                } else if(log.size() == prevLogSize){
                    int y = log.get(1);
                    log.remove(1);
                    log.set(0, log.get(0)+y);
                    counter++;
                }
                prevLogSize = log.size();
                int i=1;
                while(i<log.size()-1){
                    if(log.get(i+1)>log.get(i)){
                        int y = log.get(i);
                        log.remove(i);
                        log.set(i-1, log.get(i-1)+y);
                        counter++;

                    }
                    i++;
                }
                i = log.size()-2;
                while(i>0){
                    if(log.get(i-1)>log.get(i)){
                        int y = log.get(i);
                        log.remove(i);
                        log.set(i, log.get(i)+y);
                        counter++;
                    }
                    i--;
                }

            }

 */
