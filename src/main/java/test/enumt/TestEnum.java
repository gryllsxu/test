package test.enumt;

public class TestEnum {

	public static enum CHANNEL {
		WEIXIN("微信"),
		LIANTONG("联通");
		
		private String cnName;
		CHANNEL(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CHANNEL item:CHANNEL.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}

	public static void main(String[] args) {
		for (CHANNEL item : CHANNEL.values()) {
			System.out.println(item.getCode());
			System.out.println(item.getCnName());
			System.out.println(item.getClass());
			System.out.println(item.name());
		}
	}
}
