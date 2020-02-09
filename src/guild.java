import java.util.*;

public class guild {
    class Member {
        String name_;
        int level_;
        float kd_;

        Member(String name) {
            this.name_ = name;
        }

        void setKd(float kd) {
            this.kd_ = kd;
        }

        void setLevel(int level) {
            this.level_ = level;
        }

        Member(String[] raw) {
            this(raw[0]);
            setLevel(Integer.parseInt(raw[1]));
            setKd(Float.parseFloat(raw[2]));
        }
    }

    static Comparator<Member> GUILD_COMPARATOR  = new Comparator<Member>() {
        public int compare(Member obj1, Member obj2) {
            if (obj1.level_ > obj2.level_) {
                return 1;
            } else if (obj1.level_ < obj2.level_) {
                return -1;
            } else {
                if (obj1.kd_ > obj2.kd_) {
                    return 1;
                } else if (obj1.kd_ < obj2.kd_) {
                    return -1;
                } else {
                    return obj1.name_.compareTo(obj2.name_);
                }
            }
        }
    };

    class Guild {
        String name_;
        int points_;
        int numberOfMembers_;
        List<Member> members_ = new ArrayList<Member>();

        Guild(String name) {
            this.name_ = name;
        }

        void setMembersNum(int number) {
            this.numberOfMembers_ = number;
        }

        void setPoints(int points) {
            this.points_ = points;
        }

        void sort() {
            members_.sort(GUILD_COMPARATOR);
        }

        void print() {
            System.out.println(this.name_ + ":");
            for (Member member : members_) {
                System.out.println(member.name_);
            }
            System.out.println();
        }
    }

    static final Comparator<Guild> GUIlDS_COMPARATOR = new Comparator<Guild>() {
        public int compare(Guild obj1, Guild obj2) {
            if (obj1.points_ > obj2.points_) {
                return 1;
            } else if (obj1.points_ < obj2.points_) {
                return -1;
            } else {
                if (obj1.numberOfMembers_ > obj2.numberOfMembers_) {
                    return 1;
                } else if (obj1.numberOfMembers_ < obj2.numberOfMembers_) {
                    return -1;
                } else {
                    return obj1.name_.compareTo(obj2.name_);
                }
            }
        }
    };

    class Guilds {
        List<Guild> guilds_ = new ArrayList<Guild>();

        void sort() {
            guilds_.sort(GUIlDS_COMPARATOR);
        }

        void print() {
            for (Guild guild : guilds_)
                guild.print();
        }

    }


    public void main(String[] args) {
        Scanner oi = new Scanner(System.in);
        int numberOfGuilds = oi.nextInt();
        Guilds guilds = new Guilds();
        while (numberOfGuilds-- != 0) {
            String[] nameAndPoints = oi.nextLine().split(" "); // "name points"
            Guild guild = new Guild(nameAndPoints[0]);
            guild.setPoints(Integer.parseInt(nameAndPoints[1]));
            int members = oi.nextInt();
            guild.setMembersNum(members); //members
            while (members-- != 0)
                guild.members_.add(new Member(oi.nextLine().split(" "))); //pass raw line constructor will handle it
            guild.sort();
            guilds.guilds_.add(guild);
        }
        guilds.sort();
        guilds.print();
    }
}
