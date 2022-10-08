import '../../db/database.dart';

class Team {
  final String id;
  final String name;

  Team({required this.id, required this.name});

  factory Team.fromEntity(TeamEntity entity){
    return Team(id: entity.id!, name: entity.name);
  }

  @override
  String toString() {
    return 'Team{name: $name, 인원: 00명}';
  }

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Team &&
          runtimeType == other.runtimeType &&
          id == other.id &&
          name == other.name;

  @override
  int get hashCode => id.hashCode ^ name.hashCode;
}