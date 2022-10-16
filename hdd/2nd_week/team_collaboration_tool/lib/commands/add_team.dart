import 'dart:io';

import 'package:riverpod/riverpod.dart';

import '../core/base_command.dart';
import '../domain/services/team_service.dart';

final addTeamProvider =
    Provider<AddTeam>((ref) => AddTeam(ref.watch(teamServiceProvider)));

class AddTeam implements BaseCommand {
  final TeamService _teamService;

  AddTeam(this._teamService);

  @override
  Future<void> call() async {
    try {
      stdout.writeln('생성하려는 팀 명을 입력해주세요.');
      var teamName = stdin.readLineSync()?.trim() ?? '';
      if (teamName.isEmpty) {
        stderr.writeln('동작 실패: 팀 명을 입력해주세요.');
        return;
      }
      _teamService.addTeam(teamName);
    } catch (e) {
      stderr.writeln('동작 실패: 이미 있는 팀 명입니다.');
    }
  }
}
