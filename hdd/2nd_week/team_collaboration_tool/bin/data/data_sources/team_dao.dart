import 'package:drift/drift.dart';

import '../../db/database.dart';
import '../entities/team_table.dart';

part 'team_dao.g.dart';

@DriftAccessor(tables: [TeamTable])
class TeamDao extends DatabaseAccessor<Database> with _$TeamDaoMixin {
  TeamDao(Database db) : super(db);

  Future<TeamEntity?> getTeamOrNull(String name) {
    return (db.teamTable.select()..where((team) => team.name.equals(name)))
        .getSingleOrNull();
  }

  Future<int> insertTeam(String name) {
    return into(teamTable).insert(TeamEntity(name: name));
  }

  Future<List<TeamEntity>> getTeams() {
    return db.teamTable.select().get();
  }
}
