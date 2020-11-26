package Teamworkprojects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Member {
    private final String user;
    private final String team;
    private int count;

    public Member(String user, String team) {
        this.user = user;
        this.team = team;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUser() {
        return user;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return String.format(" %s", user);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int reg = Integer.parseInt(scanner.nextLine());

        List<Member> teamsList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();

        String read = scanner.nextLine();

        while (!"end of assignment".equals(read)) {
            String[] token = read.split("-");
            String user = token[0];
            String teamName = token[1];
            String join = token[1].substring(0, 1);
            teamName = teamName.replace(">", "");
            Member teamCurrent = new Member(user, teamName);
            Member people = new Member(user, teamName);

            if (">".equals(join)) {
                if (teamsList.isEmpty()) {
                    printNotExist(teamName);
                } else {
                    boolean isIt = true;
                    for (Member member : memberList) {
                        if ((member.getUser().equals(user))) {
                            isIt = false;
                            break;
                        }
                    }
                    int count = 0;
                    for (Member member : memberList) {
                        if (member.getTeam().equals(teamName) && isIt) {
                            memberList.add(people);
                            break;
                        } else if (member.getTeam().equals(teamName) && !isIt) {
                            System.out.println("Member " + user + " cannot join team " + teamName + "!");
                            break;
                        } else {
                            count++;
                        }
                    }
                    if (count == memberList.size()) {
                        printNotExist(teamName);
                    }
                }
            } else {
                if (teamsList.isEmpty()) {
                    teamsList.add(teamCurrent);
                    memberList.add(people);
                    printCreateTeam(teamName, user);
                    reg--;
                    read = scanner.nextLine();
                    continue;
                }
                for (Member teams : teamsList) {
                    if (!teams.getTeam().equals(teamName)) {
                        if (teams.getUser().equals(user)) {
                            System.out.println(user + " cannot create another team!");
                        } else {
                            if (reg > 0) {
                                teamsList.add(teamCurrent);
                                reg--;
                                printCreateTeam(teamName, user);
                                memberList.add(people);
                                break;
                            }else {
                                System.out.println(user + " cannot create another team!");
                            }
                        }
                    } else {
                        System.out.println("Team " + teamName + " was already created!");
                    }
                }
            }

            read = scanner.nextLine();
        }
        setTeamsList(memberList, teamsList);
        printTeams(memberList, teamsList);
        printDishbanTeams(teamsList);
    }

    private static void printDishbanTeams(List<Member> teamsList) {
        System.out.println("Teams to disband:");
        for (Member member : teamsList) {
            if (member.getCount() == 1) {
                System.out.println(member.getTeam());
            }
        }
    }

    private static void printTeams(List<Member> memberList, List<Member> teamsList) {
        for (Member member : teamsList) {
            if (member.getCount() > 1) {
                System.out.println(member.getTeam());
                System.out.println("- " + member.getUser());
                for (Member member1 : memberList) {
                    if (member.getTeam().equals(member1.getTeam())) {
                        if (1 == member1.getCount()) {
                            System.out.println("--" + member1.toString());
                        }
                    }
                }
            }
        }
    }

    private static void setTeamsList(List<Member> memberList, List<Member> teamsList) {
        for (Member member : teamsList) {
            int count = 0;
            int countFirstIndex = 0;
            for (Member member1 : memberList) {
                if (member.getTeam().equals(member1.getTeam())) {
                    count++;
                }
                if (member.getUser().equals(member1.getUser())) {
                    countFirstIndex++;
                    if (countFirstIndex == 1) {
                        member1.setCount(0);
                    }
                }
            }
            member.setCount(count);
        }
        teamsList.sort(Comparator.comparing(Member::getCount).reversed());
        memberList.sort(Comparator.comparing(Member::getUser));
    }

    private static void printNotExist(String teamName) {
        System.out.println("Team " + teamName + " does not exist!");
    }

    public static void printCreateTeam(String team, String user) {
        System.out.println("Team " + team + " has been created by " + user + "!");
    }
}
