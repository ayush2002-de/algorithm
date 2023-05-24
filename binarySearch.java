

public class binarySearch {
    public static int search(int arr[],int si,int ei,int data){

        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==data)return mid;
            if(arr[mid]>data)si=mid+1;
            else ei=mid-1;
        }
        return -1;
    }
    public static int firstIndex(int arr[],int si,int ei,int data){
        
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==data){
               if(mid>0 && arr[mid-1]==data)ei=mid-1;
               else return mid;
            }else if (arr[mid]>data)ei=mid-1;
            else si=mid+1;
        }
        return -1;
    }


    public static int lastIndex(int arr[],int si,int ei,int data) {
      
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==data){
                if(mid<arr.length && arr[mid+1]==data)si=mid+1;
               else return mid;

            }else if (arr[mid]>data)ei=mid-1;
            else si=mid+1;
        }
        return -1;
    }
    public static int closest(int arr[],int target){
        int si=0;
        int ei=arr.length-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==target){
               return mid;
            }else if(arr[mid]>target){
              if(mid>0 && arr[mid-1]<target){
                return Math.abs(arr[mid]-target)<Math.abs(arr[mid-1]-target)?mid:mid-1;

              }else ei=mid-1;
            }else {
                if(mid<arr.length-1 && arr[mid+1]>target){
                    return Math.abs(arr[mid+1]-target)<Math.abs(arr[mid]-target)?mid+1:mid;

                }else si=mid+1;
            }

        }
        if(arr[0]>target)return 0;
        else return arr.length-1;

    }
    public static int perfectPosition(int arr[],int target){
       int si=0;
       int ei=arr.length-1;
       while(si<=ei){
        int mid=(si+ei)/2;
        if(arr[mid]<=target){
          if(mid<arr.length-1 && arr[mid+1]>target)return mid+1;
          else si=mid+1;
        }else{
            if(mid>0 && arr[mid-1]<target)return mid;
            else ei=mid-1;
        }
       }
       if(arr[0]>target)return 0;
       return arr.length;
    }
    public static int[] ceilAndFloor(int arr[],int target){
        int si=0;
        int ei=arr.length-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==target){
               int ceil=-1;
               int floor=-1;
               if(mid>0)ceil=mid-1;
               if(mid<arr.length-1)floor=mid+1;
               return new int []{ceil,floor};
            }else if(arr[mid]>target){
              if(mid>0 && arr[mid-1]<target){
                return new int []{mid-1,mid};

              }else ei=mid-1;
            }else {
                if(mid<arr.length-1 && arr[mid+1]>target){
                    return new int []{mid,mid+1};

                }else si=mid+1;
            }

        }
        if(arr[0]>target)return new int []{-1,0};
        else return new int []{arr.length-1,-1};

    }
    public static void display(int arr1[],int arr[]){
        for(int a:arr1){
            if(a==-1)continue;
            System.out.print(arr[a]+" ");
        }
        System.out.println();
    }
    
    public static int closestGood(int arr[],int target){
        if(arr[0]>target)return 0;
        if(arr[arr.length-1]<target)return arr.length-1;
        int si=0,ei=arr.length-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target)ei=mid-1;
            else si=mid+1;

        }
        return target-arr[ei]<=arr[si]-target?ei:si;
    }
    public static int perfectPositionGood(int arr[],int target){
        int si=0,ei=arr.length;//range of binary search
        while(si<ei){
            int mid=(si+ei)/2;
             if(arr[mid]>target)ei=mid;
            else si=mid+1;//always check that if we exclude element in array it doesn't impact our answer
        }
        return si;
    }
    public static int[] ceilAndFloorGood(int arr[],int target){
        if(arr[0]>target)return new int []{-1,0};
        if(arr[arr.length-1]<target)return new int []{-1,arr.length-1};
        int si=0,ei=arr.length-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==target){
                int ceil=-1;
               int floor=-1;
               if(mid>0)ceil=mid-1;
               if(mid<arr.length-1)floor=mid+1;
               return new int []{ceil,floor}; 
            }
            else if(arr[mid]>target)ei=mid-1;
            else si=mid+1;

        }
        return new int []{ei,si};
    }
    
    
    
    
    public static void main(String[] args) {
        int arr[]={-5,0,7,12,18,34,50};
             
        
    }
}
