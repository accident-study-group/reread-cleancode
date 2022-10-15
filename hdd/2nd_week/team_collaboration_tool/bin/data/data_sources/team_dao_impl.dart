import 'package:drift/drift.dart';

import '../../db/database.dart';
import '../entities/team_table.dart';
import 'team_dao.dart';

part 'team_dao_impl.g.dart';

@DriftAccessor(tables: [TeamTable])
class TeamDaoImpl extends DatabaseAccessor<Database>
    with TeamDao, _$TeamDaoImplMixin {
  TeamDaoImpl(Database db) : super(db);

  @override
  Future<TeamEntity?> getTeamOrNull(String name) {
    return (db.teamTable.select()..where((team) => team.name.equals(name)))
        .getSingleOrNull();
  }

  @override
  Future<int> insertTeam(String name) {
    return into(teamTable).insert(TeamEntity(name: name));
  }

  @override
  Future<List<TeamEntity>> getTeams() {
    return db.teamTable.select().get();
  }
}
